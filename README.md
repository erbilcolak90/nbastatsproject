# NBA Player Stats Project

This project is aimed at providing insights into NBA players and their performance statistics based on different seasons. It offers the ability to learn about individual player performance as well as team-based player analytics. Additionally, the project includes methods to create "fantasy teams" and "fantasy players." The data used for this project is obtained from publicly available datasets on Kaggle. It allows you to explore details like a player's draft information, college selection, and performance statistics over the course of a season.

## Technologies Used

- Java 17
- Spring Boot 3.1.2
- Auto-complete mechanism
- Elasticsearch
- PostgreSql
- Swagger 3.0 OpenAPI
- Lombok
- Validation
- ModelMapper
- WebMvc
- Thymeleaf

## Features

- Utilizes the power of Java 17 and Spring Boot to create a robust backend for the application.
- Implements an auto-complete mechanism to enhance user experience and ease data retrieval.
- Leverages Elasticsearch for efficient and advanced search capabilities.
- Utilizes PostgreSQL as the database to store and manage data related to Database Stats, Players, and Teams.
- Employs Swagger 3.0 OpenAPI to provide a user-friendly API documentation and testing interface.
- Integrates Lombok for reducing boilerplate code and improving code readability.
- Implements validation techniques to ensure data integrity and consistency.
- Utilizes ModelMapper for seamless mapping between different layers of the application.
- Implements WebMvc for handling web-related functionalities.
- Incorporates Thymeleaf templates for rendering dynamic HTML content.

## Getting Started

To set up and run the project locally, follow these steps:

1. Clone the repository: `git clone https://github.com/your-username/nba-statistics-project.git`
2. Navigate to the project directory: `cd nba-statistics-project`
3. Configure the PostgreSQL database settings in the `application.properties` file.
4. Run the application using your IDE or by running the following command: `./mvnw spring-boot:run`
5. Access the Swagger UI documentation at: `http://localhost:8080/swagger-ui/index.html`
6. Explore the auto-complete feature on the frontend to discover player and team statistics.

Feel free to contribute, report issues, or provide suggestions for improvement.

## Acknowledgements

This project was made possible by utilizing various open-source libraries, datasets from Kaggle, and the expertise of the Java and Spring Boot communities.

## License

This project is licensed under the [MIT License](LICENSE).
