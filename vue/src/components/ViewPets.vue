<template>
  <!-- <div>
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
  </div> -->
  <div class="pet-container">
    <slick :options="slickOptions">
    <div v-for="pet in this.$store.state.pets" :key="pet.petId" class="pet-card">
     <div class="image-container"> 
        <img :src= "pet.petPhoto" alt="Photo of Pet">
      </div>
      <div>  
          <p>{{ pet. petName }}</p>
          <p>Species: {{ pet.species }}</p>
          <p> Breed: {{ pet.breed }}</p>
          <p>{{ pet.description }}</p>
      </div>
      </div>
      </div>
</template>

<script>
// import Slick from 'vue-slick-';
import 'vue-slick-carousel/dist/vue-slick-carousel.css';
import 'vue-slick-carousel/dist/vue-slick-carousel-theme.css';
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
          return this.$store.state.pets;
      }
  },
  created(){
    this.retrievePets();
    // this.retrievePets().then((response) => {
    //   this.pets = response.data;
    // })
  },
  // data() {
  //   return {
  //     slickOptions: {
  //       slidesToShow: 4,
  //       infinite: true,
  //       dots: true,
  //          }
  //   }
  // }
};
</script>


<style>
.pet-container{
  display:flex;
  flex-wrap: wrap;
  justify-content: center;
  height: 500px;
  position:fixed;
  top:350px;
}
  img {
    width: 300px;
    height: 300px;
    object-fit: cover;
  }
  .image-container {
    display: flex;
    flex-direction: row;
    justify-content: center;
    align-items: center;
    height: 300px;
    width: 300px;
    overflow-y: hidden;
  }
  .pet-card {
    margin: 10px;
    padding: 10px;
    border: 1px solid #ccc;
    border-radius: 5px;
    display: flex;
    flex-direction: column;
    align-items: center;
    max-width: 300px;
    background-color: rgba(93, 11, 93, 0.7);
    backdrop-filter: blur(10px);
    box-shadow: 0px 5px 10px rgba(0,0,0,0.2);
    transition: transform 0.3s ease-in-out;
  }
  .pet-card:hover {
  transform: translateY(-5px);
  }
</style>