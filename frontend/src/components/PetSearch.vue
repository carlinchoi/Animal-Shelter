<template>
  <div id="q-app">
    <!-- style="min-height: 100vh;" removed this from line 2 -->
    <h2>Search bar goes here Input Native form</h2>
    <div class="q-pa-md row q-gutter-md justify-center text-center">
      <q-card class="my-card">
        <h2 style='font-weight: bold'>All Pets</h2>
      </q-card>
      <q-card class="my-card">
        <q-img src="https://hips.hearstapps.com/hmg-prod/images/golden-retriever-royalty-free-image-506756303-1560962726.jpg?crop=1.00xw:0.756xh;0,0.0756xh&resize=1200:*">
        </q-img>

        <q-card-section class="text-center" style ='font-weight:bold' >
          Dogs
        </q-card-section>
      </q-card>

      <q-card class="my-card">
        <q-img src="https://hips.hearstapps.com/hmg-prod/images/cute-cat-photos-1593441022.jpg">
        </q-img>

        <q-card-section class="text-center" style ='font-weight:bold' >
          Cats
        </q-card-section>
      </q-card>

      <q-card class="my-card">
        <q-img src="https://www.tracyvets.com/files/Parakeets.jpeg">
        </q-img>

        <q-card-section class="text-center" style ='font-weight:bold' >
          Birds
        </q-card-section>
      </q-card>

      <q-card class="my-card">
        <q-img src="https://squeaksandnibbles.com/wp-content/uploads/2017/05/Girl-guinea-pig-names-SN-long.jpg">
        </q-img>

        <q-card-section class="text-center" style ='font-weight:bold' >
          Guinea Pigs
        </q-card-section>
      </q-card>

      <q-card class="my-card">
        <q-img src="https://www.thefactsite.com/wp-content/uploads/2016/03/cute-hamster-facts.jpg">
        </q-img>

        <q-card-section class="text-center" style ='font-weight:bold' >
          Hamsters
        </q-card-section>
      </q-card>

      <q-separator color="black" thickness="1px" style="height: 2px; width: 60%; margin: 0 auto; margin-top: 40px;" />
    </div>

    <div class="q-pa-md row q-gutter-md justify-center text-center">
      <q-card class="my-card " flat bordered>
        <img src="https://cdn.quasar.dev/img/parallax2.jpg">
        <q-list>
          <q-item>
            <q-item-section>
              <q-item-label class="text-weight-bold">Name:</q-item-label>
            </q-item-section>
            <q-item-section>
              <q-item-label>Watch a movie.</q-item-label>
            </q-item-section>
          </q-item>
          <q-separator />
          <q-item>
            <q-item-section>
              <q-item-label class="text-weight-bold">Species:  </q-item-label>
            </q-item-section>
            <q-item-section>
              <q-item-label>Watch a movie.</q-item-label>
            </q-item-section>
          </q-item>
          <q-separator />
          <q-item>
            <q-item-section>
              <q-item-label class="text-weight-bold">Breed: </q-item-label>
            </q-item-section>
            <q-item-section>
              <q-item-label>Watch a movie.</q-item-label>
            </q-item-section>
          </q-item>
          <q-separator />
          <q-item>
            <q-item-section>
              <q-item-label class="text-weight-bold">Description: </q-item-label>
            </q-item-section>
            <q-item-section>
              <q-item-label>Watch a movie.</q-item-label>
            </q-item-section>
          </q-item>
        </q-list>
      </q-card>
    </div>
  </div>
</template>

<script>
import petservice from "../boot/PetService";

export default {
  //test push
  name: "view-pets",
  data() {
    return {
      selectedSpecies: null,
      petPhotos: {},
    };
  },
  mounted() {
    this.retrievePets();
  },
  methods: {
    retrievePets() {
      petservice.findAllPets().then((response) => {
        this.$store.commit("SET_PET_INFO", response.data);
        response.data.forEach((pet) => {
          this.retrievePetPhotos(pet.petId);
        });
      });
    },
    retrievePetPhotos(petId) {
      petservice.findAllPhotos(petId).then((response) => {
        this.$store.commit("SET_PET_PHOTOS", { petId: petId, photos: response.data });
        this.$set(this.petPhotos, petId, response.data);
      });
    },
    selectSpecies(species) {
      this.selectedSpecies = species;
    },
    scrollToTop() {
      window.scrollTo({
        top: 0,
        behavior: 'smooth',
      });
    },
  },
  computed: {
    pets() {
      return this.$store.state.pets;
    },
    filteredPets() {
      if (!this.selectedSpecies) {
        return this.$store.state.pets;
      }
      return this.$store.state.pets.filter((pet) => pet.species === this.selectedSpecies);
    },
  },
};
</script>
