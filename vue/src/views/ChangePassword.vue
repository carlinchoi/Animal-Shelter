<template>
  <div class="login-wrapper">
    <div class="form-wrapper">
        <form @submit.prevent="changePassword">
            <h1 >Please Change Password</h1>
            <div role="alert" v-if="changePasswordErrors">
              {{ changePasswordErrorMsg}}
            </div>
            <div class="form-input-group">
              <label for="new password"> New Password</label>
              <input type="password"  v-model='password' required>
            </div>
            <div class="form-input-group">
              <label for="confirmPassword">Confirm New Password</label>
              <input type="password" v-model='confirmPassword' required/>
            </div>
            <button type="submit">Submit Password Change</button>
        </form>
    </div>
  </div>
</template>

<script>
import authService from '../services/AuthService';

  export default {
    name: 'changePassword',
    data() {
      return {
        user: {
          password: '',
          confirmPassword:''
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
        authService
          .register(this.user)
          .then((response) => {
            if (response.status == 201) {
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

form {
  display: flex;
  flex-direction: column;
  justify-content: center; 
  align-items: center; 
  height: 80vh;
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
  margin-bottom: 1rem;
  display: flex;
  flex-direction: column;
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
  padding: 5px 10px;
  font-weight: bold;
  cursor: pointer;
  transition: all 0.3s ease;
  position: relative;
  display: inline-block;
  outline: none;
  border-radius: 20px;
  border: 2px solid #4c6e5c;
  background: #62a18f;
}
button:hover {
  background: #fff;
  color: #fff;
}
.login-wrapper {
  display: flex;
  justify-content: center;
  align-items: center;
  height: 100vh;
}
* {
overflow:auto;
}
</style>