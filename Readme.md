## Trip Plan IA API

<div> 
<img align="center" alt="Java" src="https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=java&logoColor=white" />
<img align="center" alt="spring" src="https://camo.githubusercontent.com/c2a58428fe9b38967494da3b0a098f1d28f9cc395e3bbf123cbc14fb36bc1b07/68747470733a2f2f696d672e736869656c64732e696f2f62616467652f737072696e672d2532333644423333462e7376673f7374796c653d666f722d7468652d6261646765266c6f676f3d737072696e67266c6f676f436f6c6f723d7768697465" />
</div>

## About

This is an application that uses the gpt chat api to generate travel itineraries

## Installation

1. Clone this repository:

```
   git clone https://github.com/aldojunior990/trip-plan-ia-api.git
```

2. Install dependencies with Maven.

3. Generate an OpenAI key in: https://platform.openai.com/

4. Save the generated key in **aplication.properties**.

## Params

```
 currentLocal - Your city.
 destination - City you want to visit.
 countOfDays - Number of days you will spend in the city.
 travelDate - Date of your trip.
```

## Endpoints

```
 GET roadmap/generate - Generate script
.
```
