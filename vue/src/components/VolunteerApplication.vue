<template>
 <body>
    <div class="register-wrapper">
      <div class="form-wrapper">
        <div id="register" class="text-center">
<form @submit.prevent="submitForm" class="form">
  <h1>Submit Application</h1>
  <div class="form-input-group">
    <input type="text" placeholder="First Name" class="placeholder-animate" id="firstName" v-model="firstName" required>
  </div>
  <div class="form-input-group">
    <input type="text" placeholder="Last Name" class="placeholder-animate" id="lastName" v-model="lastName" required>
  </div>
  <div class="form-input-group">
    <input type="email" placeholder="Email" class="placeholder-animate" id="email" v-model="email" required>
  </div>
  <div class="form-input-group">
    <input type="tel" placeholder="Phone Number" class="placeholder-animate" id="phone" v-model="phone" required>
  </div>
  <button type="submit" class="btn">Submit</button>
</form>
  </div>
  </div>
  </div>
</body>
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
          if (response.status == 200){
            this.$router.push({
                path: '/login',
                query: { registration: 'success' },
              });
          }
        })
        // adoptionService.createAdoption(this.adoption)
        //     .then((response) => {
        //     if (response.status == 201) {
        //         this.$router.push({
        //         path: '/',
        //       });
        //     } else 
        //       this.$router.push({
        //         path: '/adoption-form-page',
        //       });
        //     }
        .catch(error => {
          console.error("Error creating volunteer application:", error);
        });
    }
  }
}
</script>

<style scoped>
body {
  /* background-image: url("../assets/background2.png"); */
  background-color: rgb(230, 222, 240);
  background-repeat: repeat;
  background-size: contain;
  min-height: 100%;
  min-width: 100%;
  margin: 0;
  padding: 0;
}
form {
  display: flex;
  flex-wrap: wrap;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  height: 100vh;
  margin-top: 0;
  max-width: 400px;
  margin: auto;
  padding: 80px;
  border: 2px solid #410553;
  border-radius: 10px;
  background-color: rgba(255, 255, 255, 0.671);
  box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.3);
  margin-bottom: 100px;
}
.form-input-group {
  margin-bottom: 0.5rem;
  display: flex;
  flex-direction: row;
  align-items: center;
}
.form-input-group .icon {
  width: 30px;
  align-self: flex-start;
  margin-right: -10px;
}
label {
  margin-right: 0.5rem;
}
input {
  padding: .5rem;
  border: 2px solid #ccc;
  padding: 10px;
  border-radius: 10px;
}
.placeholder-animate::-webkit-input-placeholder {
  transition: all 0.3s ease-out;
  opacity: 0.5;
  transform: translateY(0px);
}
.placeholder-animate:focus + .floating-placeholder,
.placeholder-animate.valid + .floating-placeholder {
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
}
button {
  min-width: 130px;
  height: 40px;
  color: #fff;
  padding: -5px 5px;
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
</style>