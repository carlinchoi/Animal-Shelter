<template>
  <form @submit.prevent="submitForm">
    <label for="firstName">First Name:</label>
    <input type="text" id="firstName" v-model="firstName" required>

    <label for="lastName">Last Name:</label>
    <input type="text" id="lastName" v-model="lastName" required>

    <label for="email">Email:</label>
    <input type="email" id="email" v-model="email" required>

    <label for="phone">Phone:</label>
    <input type="tel" id="phone" v-model="phone" required>

    <button type="submit">Submit</button>
  </form>
</template>

<script>

import VolunteerService from '../services/VolunteerService';

export default {
  data() {
    return {
      firstName: '',
      lastName: '',
      email: '',
      phone: ''
    }
  },
  methods: {
    submitForm() {
      const volunteerApplication = {
        firstName: this.firstName,
        lastName: this.lastName,
        email: this.email,
        phone: this.phone
      };

      VolunteerService.createVolunteerApplication(volunteerApplication)
        .then(response => {
          console.log(response.data);
        })
        .catch(error => {
          console.error("Error creating volunteer application:", error);
        });
    }
  }
}
</script>

<style>
.volunteer-form {
  display: flex;
  flex-direction: column;
  max-width: 600px;
  margin: 0 auto;
  padding: 20px;
  background-color: #f7f7f7;
  border-radius: 5px;
}

.form-group {
  display: flex;
  flex-direction: column;
  margin-bottom: 20px;
}

label {
  font-weight: bold;
  margin-bottom: 5px;
}

input {
  padding: 10px;
  border: none;
  border-radius: 3px;
  font-size: 16px;
  background-color: #ffffff;
  box-shadow: 0px 2px 5px rgba(0, 0, 0, 0.1);
}

.submit-btn {
  padding: 10px 20px;
  background-color: #1a73e8;
  color: #ffffff;
  border: none;
  border-radius: 3px;
  font-size: 16px;
  cursor: pointer;
  transition: background-color 0.3s ease-in-out;
}

.submit-btn:hover {
  background-color: #0d47a1;
}
</style>