from dash import Dash, html, dcc
from dash.dependencies import Input, Output
import requests
import datetime
import plotly.express as px

# Obtains the data for graph
# OpenWeatherMap API Endpoint. Read about this here: https://openweathermap.org/appid
API_ENDPOINT = "http://api.openweathermap.org/data/2.5/forecast"
API_KEY = ""  # Replace with your own API key


zip_code = "50311"

# API parameters
params = {
    'zip': f"{zip_code},us",  # Assuming US ZIP code for simplicity, modify for other countries
    'appid': API_KEY,
    'units': 'imperial'  # Get weather in Fahrenheit. Change to 'metric' for Celsius.
}

response = requests.get(API_ENDPOINT, params=params)
DATA = response.json()

# Check if the response contains the necessary data. 
if "list" not in DATA:
    print("Couldn't fetch the weather details.")


relevant_forecasts = DATA["list"]




def format_forecast_data(relevant_forecasts):
    forecast_times = [datetime.datetime.utcfromtimestam3p(forecast["dt"]) for forecast in relevant_forecasts]

    forecast_data = [x["main"] for x in relevant_forecasts]
    formatted_data = []

    for i in range(len(forecast_data)):
        formatted_data.append(forecast_data[i])
        formatted_data[i]["time"] = forecast_times[i]
    return formatted_data


forecast_data = format_forecast_data(relevant_forecasts)





''' Now that we put our data in the right format, we're going to try to 
make a webapge out of it using Dash and plotly!'''



#creates the initial figure 
fig = px.line(forecast_data, x="time", y="temp", title='Forecast')
fig2 = px.line(forecast_data, x="time", y="humidity", title='humidity outlook')
fig3 = px.line(forecast_data, x="time", y="pressure", title='pressure outlook')
app = Dash(__name__)

app.layout = html.Div(children = [
    dcc.Markdown( # sets a heading above the dropdown and graph
        id = "title",
        children = "## Weather Forecast for " + zip_code
    ),

    dcc.Dropdown( # creates a dropdown to select values to display
        id = "measure_select_dropdown",
        options = [{'label':"temp", 'value':"temp"},
                   {'label':"humidity", 'value':"humidity"},
                   {'label':"pressure", 'value':"pressure"},
                   {'label':"feels_like", 'value':"feels like temp"},
                   {'label':"grnd_level", 'value':"ground level"}], 
        value ="temp",
        multi = False #allows selection of multiple values
    ),

    dcc.Graph( #displays the graph on the page
        id = "weather_line_graph",
        figure = fig

    )
    
])

@app.callback(
    Output("weather_line_graph","figure"),
    Input("measure_select_dropdown","value"),
)
def update_output(value):
    if value == 'temp':
        fig = px.line(forecast_data, x="time", y="temp", title='Forecast')
        figure = fig
        return figure
    elif value == 'humidity':
        fig = px.line(forecast_data, x="time", y="humidity", title='humidity outlook')
        figure = fig
        return figure
    elif value == 'pressure':
        fig = px.line(forecast_data, x="time", y="pressure", title='pressure outlook')
        figure = fig
        return figure
    elif value == 'feels like temp':
        fig = px.line(forecast_data, x="time", y="feels_like", title='feels like temp outlook')
        figure = fig
        return figure
    elif value == 'ground level':
        fig = px.line(forecast_data, x="time", y="grnd_level", title='ground level outlook')
        figure = fig
        return figure

    

if __name__ == '__main__': # starts the server
    app.run_server(debug=True)
