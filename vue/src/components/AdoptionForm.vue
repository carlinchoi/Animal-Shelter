<template>
<body>
   <div>
    <div class="form-wrapper">
        <form @submit.prevent="addAdoptionForm">
            <h1>Parent Info</h1>
            <div class="form-input-group"> 
              <ion-icon name="person-outline"></ion-icon><input type="text" class="placeholder-animate" placeholder="Parent Name" v-model='adoption.parentName' required>
            </div>
            <div class="form-input-group">
              <ion-icon name="mail-outline"></ion-icon><input type="email" placeholder="Parent Email" class="placeholder-animate" v-model='adoption.parentEmail' required>
            </div>
             <div class="form-input-group"> 
              <input type="date" class="placeholder-animate" value="2018-07-22" placeholder="Adoption Date" min="2018-01-01" max="2023-12-31" v-model='adoption.adoptionDate'>
            </div>
            <button type="submit">Submit Adoption Form</button>
        </form>
    </div>
  </div>
  </body>
</template>

<script>
import adoptionService from '../services/AdoptionService.js';
export default{
    name: 'adoption-form',
    props: ["petId", "petName"],
    data() {
        return {
            adoption: {
              petId: this.petId,
              adoptionDate: '',
              parentName:'',
              parentEmail:'',
              petName: this.petName
          }
        }
    },
    methods: {
        addAdoptionForm() {
            adoptionService.createAdoption(this.adoption)
            .then((response) => {
            if (response.status == 201) {
                this.$router.push({
                path: '/',
              });
            } else 
              this.$router.push({
                path: '/adoption-form-page',
              });
            }
          )
          .catch((error) => {
            const response = error.response;
            this.registrationErrors = true;
            if (response.status === 400) {
              this.registrationErrorMsg = 'Bad Request: Validation Errors';
            }
          });
      }
    },
}
</script>

<style scoped>
h1 {
  border: 1px solid black;
  background: #62a18f;
  color: white;
  padding: 20px;
  border-radius: 50%
}
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
  padding: 0.5rem;
  border: 2px solid rgb(0, 0, 0);
  padding: 10px;
  border-radius: 10px;
}
input[type="date"] {
  width: 100%;
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
