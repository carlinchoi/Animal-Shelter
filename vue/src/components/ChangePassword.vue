<template>
   <div class="login-wrapper">
    <div class="form-wrapper">
        <form @submit.prevent="changePassword">
            <h1 >Please Change Password</h1>
            <div role="alert" v-if="changePasswordErrors">
              {{ changePasswordErrorMsg }}
            </div>
            <div class="form-input-group">
              <label for="new password"> New Password</label>
              <input type="password"  v-model='user.password' required>
            </div>
            <div class="form-input-group">
              <label for="confirmPassword">Confirm New Password</label>
              <input type="password" v-model='user.confirmPassword' required/>
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
  background-image: url("../assets/background2.png");
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