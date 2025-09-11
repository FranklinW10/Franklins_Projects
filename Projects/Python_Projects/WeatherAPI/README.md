# Weather API Dashboard

A Python web application that fetches weather forecast data from the **OpenWeatherMap API** and visualizes it interactively using **Dash** and **Plotly**. Users can view temperature, humidity, pressure, and other measurements over time for a specified ZIP code.

>  **Note:** This project requires a valid OpenWeatherMap API key. Without it, the app will not fetch live data.

---

## Technologies

- Python 3 
- [Dash](https://dash.plotly.com/) — for building interactive web dashboards  
- [Plotly](https://plotly.com/python/) — for plotting graphs  
- [Requests](https://docs.python-requests.org/) — for API calls  
- OpenWeatherMap API — to obtain weather forecast data  

---

## How to Run
1. Clone the repository:

```bash
git clone https://github.com/FranklinW10/Franklins_Projects.git
cd Franklins_Projects/Projects/Python_Projects/WeatherAPI
```
2. Install required packages:

```bash
pip install dash plotly requests
```

3. Obtain a free **API key** from [OpenWeatherMap](https://openweathermap.org/api) and add it to the `API_KEY` variable in `weather_api.py`.

>  Without a valid API key, the app will not be able to fetch weather data and will not display any graphs.

4. Run the app:
```bash
python3 weather.py
```


## Features

- Interactive line graphs for:
  - Temperature  
  - Humidity  
  - Pressure  
  - Feels-like temperature  
  - Ground level pressure  
- Built using Dash and Plotly for a modern web interface  
- Dynamic updates via dropdown selection  

---

## Future Improvements

- Allow users to input any ZIP code dynamically  
- Include additional weather metrics (wind speed, precipitation, UV index)  
- Deploy as a public web app for global access  
- Add data caching to reduce API calls and improve performance
