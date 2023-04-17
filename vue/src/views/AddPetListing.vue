<template>
<body>
   <div>
    <div class="form-wrapper">
        <form @submit.prevent="addNewPet">
            <h1 >Add New Pet Listing</h1>
            <div class="form-input-group">

              <input type="text" placeholder="Name" class="placeholder-animate" v-model='pet.petName' required/>
            </div>
            <div class="form-input-group">

              <input type="text" placeholder="Species" class="placeholder-animate" v-model='pet.species' required>
            </div>
            <div class="form-input-group">
              <input type="text" placeholder="Gender" class="placeholder-animate" v-model='pet.gender' required>
            </div>
            <div class="form-input-group">
              <input type="text" placeholder="Breed" class="placeholder-animate" v-model='pet.breed' required>
            </div>
            <div class="form-input-group">
              <input type="number" placeholder="Age" class="placeholder-animate" v-model='pet.age' required>
            </div>
            <div class="form-input-group">
              <input type="text" placeholder="Description" class="placeholder-animate" v-model='pet.description' required>
            </div>
            <div class="form-input-group">
              <input type="url" placeholder="Photo URL" class="placeholder-animate" v-model='pet.petPhoto' required>
            </div>
            <button type="submit">Submit New Listing</button>
        </form>
    </div>
  </div>
  </body>
</template>

<script>
import petService from '../services/PetService.js';
export default{
    name: 'addPetListing',
    data() {
        return {
            pet: {
                petName: '',
                species: '',
                gender: '',
                breed: '',
                age: '',
                description: '',
                isAdopted: false,
                petPhoto: ''
            }
        }
    },
    methods: {
        addNewPet() {
            petService.createPet(this.pet)
            .then((response) => {
            if (response.status == 200) {
              this.$router.push({
                path: '/',
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
    }
    
}
</script>

<style scoped>
body {
  background-image: url('../assets/background2.png');
  background-color:rgb(195, 226, 199);
  background-repeat: repeat;
  background-size: contain;
  min-height: 100%;
  min-width: 100%;
  margin: 0;
  padding: 0;
  overflow:hidden;
}
form {
  display: flex;
  flex-direction: column;
  justify-content: center; 
  align-items: center; 
  height: 60vh;
  margin-top: -10vh;
  max-width: 400px;
  margin: auto;
  padding: 40px;
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
  padding:10px;
  border-radius:10px;
}
button {
  min-width: 130px;
  height: 40px;
  color: #fff;
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
.form-wrapper{
  margin-top: 200px;
}
.login-wrapper {
  display: flex;
  justify-content: center;
  align-items: center;
  height: 100vh;
  overflow: hidden;
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
}
</style>
