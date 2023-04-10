<template>
  <div class="home">
    <h1>Home</h1>
    <p>You must be authenticated to see this</p>
    <view-pets />
      <!-- <div>
      <table>
          <thead>
              <tr>
                  <th>Pet</th>
              </tr>
          </thead>
          <tbody>
              <tr v-for="pet in pets" :key="pet.PetId">
                        <td> {{ petInfo.breed }}</td>     
              </tr>
          </tbody>
      </table>
  </div> -->
  </div>
</template>

<script>
import petservice from '../services/PetService.js';
export default {
  name: "home",
  data() {
    return {
      pets:[]
    }
  },
  methods: {
    retrievePets(){
      petservice.findAllPets().then((response) => {
        this.$store.commit("SET_PET_INFO", response.data);
      })
    }
  },
  created(){
    this.retrievePets().then((response) => {
      this.pets = response.data;
    })
  }
};
</script>

<style>
html, body {
  height: 100%;
}
.home {
 
}
</style>
