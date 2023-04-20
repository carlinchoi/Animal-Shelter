<template>
   <div class="login-wrapper">
    <div class="form-wrapper">
        <form @submit.prevent="changePassword">
            <h1 >Account Approved!</h1>
            <h2> Please Change Your Password. </h2>
            <div role="alert" v-if="changePasswordErrors">
              {{ changePasswordErrorMsg }}
            </div>
            <div class="form-input-group">
              <ion-icon name="lock-closed-outline"></ion-icon
              ><input type="password" class="placeholder-animate" placeholder="New Password"  v-model='user.password' required>
            </div>
            <div class="form-input-group">
              <ion-icon name="lock-closed-outline"></ion-icon
              ><input type="password" class="placeholder-animate" placeholder="Confirm New Password" v-model='user.confirmPassword' required/>
            </div>
            <button type="submit">Submit Password Change</button>
        </form>
    </div>
  </div>
</template>

<script>
import userService from '../services/UserService.js';
export default {
    name: 'changePassword',
    data() {
      return {
        user: {
          username: this.$store.state.user.username,
          password: '',
          confirmPassword:'',
          role: 'volunteer'
        },
        changePasswordErrors: false,
        changePasswordErrorMsg: 'There were problems changing the password for this user.',
      }
    },
    methods: {
      changePassword() {
        if (this.user.password != this.user.confirmPassword) {
          this.changePasswordErrors = true;
          this.changePasswordErrorMsg = 'Password & Confirm Password do not match.';
        } else {
        userService
          .updateUserPassword(this.user)
          .then((response) => {
            if (response.status == 200) {
              this.$router.push({
                path: '/login',
                query: { registration: 'success' },
              });
            }
          })
          .catch((error) => {
            const response = error.response;
            this.registrationErrors = true;
            if (response.status === 400) {
              this.registrationErrorMsg = 'Bad Request: Validation Errors';
            }
          });
      }
    },
    clearErrors() {
      this.registrationErrors = false;
      this.registrationErrorMsg = 'There were problems registering this user.';
    },
  },
};
</script>


<style scoped>

body {
  background-color: rgb(230, 222, 240);
  background-repeat: repeat;
  background-size: contain;
  min-height: 100%;
  min-width: 100%;
  margin: 0;
  padding: 0;
}
h1 {
  border: 1px solid black;
  background: #62a18f;
  padding: 20px;
  border-radius: 50%
  
}
h2 {
  padding: .5rem;
  font-size: 120%;
  background: #62a18f;
  border: 1px solid black;
  padding: 10px;
  border-radius: 10px;
  
}
form {
  background-image: url("../assets/background2.png");
  display: flex;
  flex-wrap: wrap;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  height: 100vh;
  margin-top: 0;
  max-width: 400px;
  color: white;
  margin: auto;
  padding: 80px;
  border: 2px solid #410553;
  border-radius: 10px;
  background-color: rgb(195, 226, 199, 0.2);
  box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.3);
  
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

.placeholder-animate {
  width: 100%;
  border: none;
  padding: 12px 20px;
  margin: 8px 0;
  box-sizing: border-box;
  border-radius: 5px;
  font-size: 16px;
  border: 2px solid rgb(0, 0, 0);
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