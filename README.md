# NBA Player and Team Statistics Project

This project aims to provide insights into NBA players and their performance statistics across different seasons. It offers the ability to learn about individual player performances as well as team-based player analytics. Additionally, the project includes methods for creating "fantasy teams" and "fantasy players." The dataset used for this project is sourced from publicly available data on Kaggle. Users can explore details such as a player's draft information, college selection, and season-long performance statistics.

## Technologies Used

- Java 17
- Spring Boot 3.1.2
- Auto-complete mechanism
- Elasticsearch
- PostgreSQL
- MongoDB
- JUnit Test
- Swagger 3.0 OpenAPI
- Lombok
- Validation
- ModelMapper
- WebMvc
- Thymeleaf

## Features

- Developed using Java 17 and Spring Boot, offering a robust backend for the application.
- Implements an auto-complete mechanism to enhance user experience and streamline data retrieval.
- Leverages Elasticsearch for efficient and advanced search capabilities.
- Utilizes PostgreSQL for storing and managing data related to Database Stats, Players, and Teams.
- Integrates MongoDB for storing data sourced from a Third-Party API, offering additional team information and statistics.
- Employs JUnit Test for comprehensive testing of application components.
- Features Swagger 3.0 OpenAPI for comprehensive API documentation and testing.
- Integrates Lombok for reducing boilerplate code and improving code readability.
- Implements validation techniques to ensure data integrity and consistency.
- Utilizes ModelMapper for seamless mapping between different layers of the application.
- Implements WebMvc for handling web-related functionalities.
- Incorporates Thymeleaf templates for rendering dynamic HTML content.

## Getting Started

To set up and run the project locally, follow these steps:

1. Clone the repository: `git clone https://github.com/your-username/nba-statistics-project.git`
2. Navigate to the project directory: `cd nba-statistics-project`
3. Configure the MongoDB Atlas connection settings and Third-Party API key in the `application.yml` file.
4. Run MongoDB replica sets using Docker Compose by executing: `docker-compose -f docker-compose.yml up -d`
5. Run the application using your IDE or by running the following command: `./mvnw spring-boot:run`
6. Access the Swagger UI documentation at: `http://localhost:8080/swagger-ui/index.html`
7. Explore the auto-complete feature on the frontend to discover player and team statistics.
8. Utilize Third-Party API integration to access additional team data.

Please note that the Third-Party API integration's free version has limited requests, so currently only one team's information can be fetched via the API. Ensure you create an account and integrate the API key in the `application.yml` file.

Feel free to contribute, report issues, or provide suggestions for improvement.

## Acknowledgements

This project was made possible by utilizing various open-source libraries, datasets from Kaggle, and the expertise of the Java, Spring Boot, Elasticsearch, and MongoDB communities.

## License

This project is licensed under the [MIT License](LICENSE).
