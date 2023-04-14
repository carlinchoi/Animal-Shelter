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
/* body {
  background-image: url('../assets/background2.png');
  background-color: rgb(192, 224, 191);
  background-repeat: repeat;
  background-size: contain;
  min-height: 100%;
  min-width: 100%;
  margin: 0;
  padding: 0;
}
form {
  display: flex;
  flex-direction: column;
  justify-content: center; 
  align-items: center; 
  height: 100vh;
  margin-top: 20vh;
  max-width: 400px;
  margin: auto;
  padding: 80px;
  border: 2px solid #410553;
  border-radius: 10px;
  background-color: rgba(255, 255, 255, 0.671);
  box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.3);
  }
.form-input-group {
  margin-bottom: .5rem;
  display: flex;
  flex-direction: row;
  align-items: center;
}
.form-input-group .icon {
  width: 30px;
  align-self: flex-start;
  margin-right: -10px
}
label {
  margin-right: 0.5rem;
}
input {
  padding: 0.5rem;
  border: 2px solid #ccc;
  border-radius: 5px;
  
}
button {
  min-width: 130px;
  height: 40px;
  color: #fff;
  padding: 5px 5px;
  font-weight: bold;
  cursor: pointer;
  transition: all 0.3s ease;
  position: relative;
  display: inline-block;
  outline: none;
  border-radius: 20px;
  border: 2px solid #4c6e5c;
  background: #62a18f;
  margin-top: 0px;
}
button:hover {
  background: #fff;
  color: #fff;
}
.register-wrapper {
  display: flex;
  justify-content: center;
  align-items: center;
  height: 100vh;
}
body {
  overflow: hidden;
}
.placeholder-animate::-webkit-input-placeholder {
  transition: all 0.3s ease-out;
  opacity: 0.5;
  transform: translateY(0px);
}
.placeholder-animate:focus + .floating-placeholder,
.placeholder-animate.valid + .floating-placeholder{
    font-size: 16px;
    top: -10px;
    left: 10px;
    color: rgb(197, 172, 228);
}
.placeholder-animate {
    width: 100%;
    border: none;
    padding: 12px 20px;
    margin: 8px 0;
    box-sizing: border-box;
    border-radius: 5px;
    font-size: 16px;
  }
  .placeholder-animate:not(:focus) {
  border-bottom: 1px solid #62a18f;
} */
</style>