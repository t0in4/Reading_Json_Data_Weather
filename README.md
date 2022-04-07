# Reading_Json_Data_Weather
use the free OpenWeatherMap.org API for the purpose of this activity.
Documentation can be found at https://www.metaweather.com/api/ . To sign up for an
API token, please go to https://home.openweathermap.org/users/sign_up . You can find
your keys and generate new ones as needed at https://home.openweathermap.org/
api_keys .
The steps are as follows:
1. Create a new app.
2. Grant internet permissions to the app in order to be able to make API and
   image requests.
3. Add Retrofit, the Moshi converter, and Glide to the app.
4. Update the app layout to support the presentation of the weather in a textual
   form (short and long description) as well as a weather icon image.
5. Define the model. Create classes that will contain the server response.
6. Add the Retrofit service for the OpenWeatherMap API, https://api.
   openweathermap.org/data/2.5/weather .
7. Create a Retrofit instance with a Moshi converter.
8. Call the API service.
9. Handle the successful server response.
10. Handle the different failure scenarios.

TO DO: Update to support weather icon image
