<template>
   <div>
    <div class="form-wrapper">
        <form @submit.prevent="addAdoptionForm">
            <!-- <div class="form-input-group">
              <label for="adoption date"> Adoption Date 'YYYY-MM-DD'</label>
              <input type="text"  v-model='adoption.adoptionDate' required>
            </div> -->
            Please add Information About the Pet's Adopter
            <div class="form-input-group"> 
              <label for="parent name"> Parent Name </label>
              <input type="text"  v-model='adoption.parentName' required>
            </div>
            <div class="form-input-group"> 
              <label for="adoption date"> Date </label>
              <input type="date" value="2018-07-22"  min="2018-01-01" max="2023-12-31" v-model='adoption.adoptionDate'>
            </div>
            <div class="form-input-group">
              <label for="parent-email"> Parent Email </label>
              <input type="email"  v-model='adoption.parentEmail' required>
            </div>
            <button type="submit">Submit Adoption Form</button>
        </form>
    </div>
  </div>
</template>

<script>
import adoptionService from '../services/AdoptionService.js';
export default{
    name: 'adoption-form',
    props: ["petId", "petName"],
    //pet: Object,
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
  //   created() {
  //   petService
  //     .getPetById(this.petId)
  //     .then(response => {
  //       this.$store.commit("SET_ACTIVE_PET", response.data);
  //       this.pet = response.data;
  //       //this.pet.species = response.data.pet.species;
  //     })
  //     .catch(error => {
  //       if (error.response.status == 404) {
  //         this.$router.push({name: 'NotFound'});
  //       }
  //     });
  //   //this.pet = this.$route.params.pet;
  // }
    
}
</script>

<style scoped>

</style>
