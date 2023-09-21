# Rockville Animal Shelter Web Application

## Introduction

Welcome to the Rockville Animal Shelter web application! This project allows users to browse, adopt, and contribute to animals in need. Whether you're looking to provide a forever home to a furry friend or simply want to support this noble cause, our platform is here to assist you.

## Features

- **Browse Animals**: Easily filter and search for animals by type, breed, age, gender, and location.
- **View Animal Profiles**: Access detailed information, photos, and stories for each animal, helping you make an informed decision.
- **Adopt an Animal**: Initiate the adoption process by filling out an online form and completing the necessary payments.
- **User Accounts && Authentication**: Create your own user account to interact with the community and share your adoption stories and photos depending on your account role.
- **Confirm Adoptions and Hire Volunteers***: Admins and volunteers can update pets as adopted as well as hire Volunteers through their user accounts.
- **Pet Search**: Search for stories and photos using keywords or tags.
- **Admin Panel**: For administrators, manage animals in the database, adoption requests, donations, user accounts, and more.

## Technologies Used

This project is built using the following technologies:

- **Vue.js**: Front-end development.
- **Quasar**: Responsive design and UI components.
- **Axios**: For making HTTP requests.
- **Java and Spring Boot**: Back-end development.
- **PostgreSQL**: Database management.

## Installation

To run this project locally, you'll need to have Java, Maven, and PostgreSQL installed on your machine. Follow these steps:

1. Clone this repository to your local directory:
```bash
git clone https://github.com/carlinchoi/Animal-Shelter.git
```
2. Navigate to the `java/database` folder and run the command to create the database and tables:
```bash
./create.sh
```
4. Edit the `application.properties` file in the `java/src/main/resources` folder with your database credentials.

5. Run the following command in the `java` folder of the project to start the back-end server:
```bash
mvn spring-boot:run
```
6. Navigate to the `client` folder and run the following command to start the front-end server:
```bash
npm start
```
7. Open your browser and go to `http://localhost:8080` to access the web application.

## Demo

You can experience a live demo of this project by visiting the [Rockville Animal Shelter website](https://www.rockvilleanimalshelter.com/#/).

## License

This project is licensed under the MIT License. For more details, please refer to the [LICENSE](LICENSE) file.

We hope you enjoy using our platform and consider contributing to the welfare of animals in need. Feel free to explore, adopt, and share your stories with the community!
