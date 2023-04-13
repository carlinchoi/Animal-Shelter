<template>
   <div>
    <div class="form-wrapper">
        <form @submit.prevent="addNewPet">
            <h1 >Add Details About New Pet Listing</h1>
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
              <input type="text"  v-model='pet.age' required>
            </div>
            <div class="form-input-group">
              <label for="pet description"> Description </label>
              <input type="text"  v-model='pet.description' required>
            </div>
            <div class="form-input-group">
              <label for="pet photo"> Photo Url </label>
              <input type="url"  v-model='pet.petPhoto' required>
            </div>
            <button type="submit">Submit New Listing</button>
        </form>
    </div>
  </div>
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

<style>

</style>
