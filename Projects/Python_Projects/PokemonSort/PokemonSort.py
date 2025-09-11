import json
from pprint import pprint #for displaying the data in an easier-to-read way

def get_Height(x):
    return x["Height"]

with open('pokemonDB_dataset.json') as pokemonfile:
    pokemon = json.load(pokemonfile)


for i in pokemon:
    pokemon[i]['name'] = i
    


#pokemon.sort(key=get_Height,reverse=True)
#pprint(list(pokemon.items())[:10])

def mergeSort(alistofpokemon, sortBy):

    if len(alistofpokemon)>1:
        mid = len(alistofpokemon)//2
        lefthalf = alistofpokemon[:mid]
        righthalf = alistofpokemon[mid:]

        mergeSort(lefthalf, sortBy)
        mergeSort(righthalf, sortBy)

        i=0
        j=0
        k=0
 
        while i < len(lefthalf) and j < len(righthalf):
            if lefthalf[i][sortBy] >= righthalf[j][sortBy]:
                alistofpokemon[k]=lefthalf[i]
                i=i+1
            else:
                alistofpokemon[k]=righthalf[j]
                j=j+1
       
            k=k+1

        
        while i < len(lefthalf):
            alistofpokemon[k]=lefthalf[i]
            i=i+1
            k=k+1
        
        while j < len(righthalf):
            alistofpokemon[k]=righthalf[j]
            j=j+1
            k=k+1

    return alistofpokemon
    #print([pokemon[sortBy] for pokemon in alistofpokemon[:10]], pokemon)



def sorted_pokemon(alistofpokemon):
    print("Which Metric are you interested in:")
    print("0: Height")
    print("1: Weight")
    print("2: Base Exp")
    print("3: HP Base")
    print("4: Defense Base")
    print("5: Attack Base")
    print("6: Speed Base")
    print("enter a number between 0-6:",end=' ')



    thisdict={0:"Height",
              1:"Weight",
              2:"Base Exp",
              3:"HP Base",
              4:"Defense Base",
              5:"Attack Base",
              6:"Speed Base"}

    sortBy = thisdict[int(input())]

    num = int(input("How many entries would you like to see? "))
    while num >1215:
        print("Enter a number smaller then 1215")
        num = int(input("How many do you want to see? "))
    
    mergeSort(alistofpokemon, sortBy)
    for pokemon in alistofpokemon[:num]:
        print("Name:", pokemon['name'],' -------- ', sortBy+":", pokemon[sortBy])
    
    print("Would you like to sort by another metric? (y/n):", end=' ')
    answer = input()
    if answer == "y":
        sorted_pokemon(alistofpokemon)
    if answer == "n":
        return None

    
        

sorted_pokemon(list(pokemon.values()))
