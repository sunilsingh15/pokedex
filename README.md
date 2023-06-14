# Pokédex

A simple Pokédex web application of the original 150 Pokémon.
A huge thanks to the wonderful https://pokeapi.co/ for their RESTful API.

## Technologies used:
- Spring Boot
- Thymeleaf

## Issues
- Currently the homepage takes around 11 seconds to load, which is far too long. I plan to explore further optimisations to the code, including both caching the Pokemon data upon initial run as well as running the loop and add to list function asynchronously.