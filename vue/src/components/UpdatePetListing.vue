<template>
   <div>
    <div class="form-wrapper">
        <form @submit.prevent="updatePet">
            <div class="form-input-group">
              <label for="pet name"> Name </label>
              <input type="text"  v-model='pet.petName' required>
            </div>
            <div class="form-input-group">
              <label for="pet species"> Species </label>
              <input type="text"  v-model='pet.species' required>
            </div>
            <div class="form-input-group">
              <label for="pet gender"> Gender </label>
              <input type="text"  v-model='pet.gender' required>
            </div>
            <div class="form-input-group">
              <label for="pet breed"> Breed </label>
              <input type="text"  v-model='pet.breed' required>
            </div>
            <div class="form-input-group">
              <label for="pet age"> Age </label>
              <input type="number"  v-model='pet.age' required>
            </div>
            <div class="form-input-group">
              <label for="pet description"> Description </label>
              <input type="text"  v-model='pet.description' required>
            </div>
            <div class="form-input-group">
              <label for="pet photo"> Photo Url </label>
              <input type="url"  v-model='pet.petPhoto' required>
            </div>
            <div class="form-input-group">
              <label for="is adopted"> Has this pet been adopted? </label>
              <input type="checkbox"  v-model='pet.adopted' >
            </div>
            <button type="submit">Submit New Listing</button>
        </form>
    </div>
  </div>
</template>

<script>
import petService from '../services/PetService.js';
export default{
    name: 'update-pet-listing',
    props: ["petId"], 
    //pet: Object,
    data() {
        return {
            pet: {
                petId: this.petId,
                petName: "",
                species: "",
                adoptionDate: null,
                gender: "",
                breed: "",
                age: "",
                description: "",
                petPhoto: "",
                adopted: ""
            }
        }
    },
    methods: {
        updatePet() {
            petService.updatePet(this.petId, this.pet)
            .then((response) => {
            if (response.status == 200) {
              this.$router.push({
                path: '/',
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
    created() {
    petService
      .getPetById(this.petId)
      .then(response => {
        this.$store.commit("SET_ACTIVE_PET", response.data);
        this.pet = response.data;
        //this.pet.species = response.data.pet.species;
      })
      .catch(error => {
        if (error.response.status == 404) {
          this.$router.push({name: 'NotFound'});
        }
      });
    //this.pet = this.$route.params.pet;
  }
    
}
</script>

<style scoped>
body {
  background-image: url('../assets/background2.png');
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
  margin-top: 0px;
  
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
body {
  overflow: hidden;
}
</style>
