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
  props: ["username"],
  methods: {
    submitForm() {
      const volunteerApplication = {
        username:this.username,
        firstName: this.firstName,
        lastName: this.lastName,
        email: this.email,
        phone: this.phone
      };
      console.log(volunteerApplication);
      
      VolunteerService.updateVolunteer(volunteerApplication)
        .then(response => {
          console.log(response.data);
            this.$router.push({
                path: '/login',
                query: { registration: 'success' },
              });
        })
        .catch(error => {
          console.error("Error creating volunteer application:", error);
        });
    }
  }
}
</script>

<style>
</style>