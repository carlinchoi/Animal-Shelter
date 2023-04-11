<template>
  <div>
      <table>
          <thead>
              <tr>
                  <th>Pet</th>
              </tr>
          </thead>
          <tbody>
              <tr v-for="pet in this.$store.state.pets" :key="pet.petId">
                  <td >{{ pet.petId }}</td>
                  <td> {{ pet.petName }}</td>
                  <td>{{ pet.gender }}</td>
              </tr>
          </tbody>
      </table>
  </div>
</template>

<script>
import petservice from '../services/PetService';
export default {
  name: "view-pets",
  methods: {
    retrievePets(){
      petservice.findAllPets().then((response) => {
        this.$store.commit("SET_PET_INFO", response.data);
      });
    }
  },
  computed: {
      pets() {
          return this.$store.state.petInfo;
      }
  },
  created(){
    this.retrievePets();
    // this.retrievePets().then((response) => {
    //   this.pets = response.data;
    // })
  }
};
</script>


<style>

</style>