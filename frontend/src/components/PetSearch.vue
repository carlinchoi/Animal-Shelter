<template>
  <div id="q-app">
    <div>
      <h3 class="text-center" style="font-weight: bold">
        Browse Available Pets For Adoption
      </h3>
    </div>
    <div class="q-flex q-justify-center">
      <div class="q-gutter-md">
        <q-toolbar class="q-toolbar--justify-center">
          <q-input
            v-model="searchQuery"
            type="text"
            label="Search Pets by Name, Species, or Breed"
            outlined
            color="primary"
            input-class="search-input"
            class="q-mr-md q-ml-md vertical"
            style="margin: 0 auto; width: 25%"
          >
            <template v-slot:prepend>
              <q-icon name="search" />
            </template>
            <template v-slot:append>
              <q-icon
                name="clear"
                class="cursor-pointer"
                @click="searchQuery = ''"
              />
            </template>
          </q-input>
        </q-toolbar>
      </div>
    </div>

    <div class="search-container text-center" style="font-weight:bold; margin: 0;">
      <h6>Search by Category: <span style="text-decoration: underline; cursor: pointer;" @click="selectSpecies(null)">All Pets</span>,  <span style="text-decoration: underline; cursor: pointer;" @click="selectSpecies('Dog')">Dogs</span>, <span style="text-decoration: underline; cursor: pointer;" @click="selectSpecies('Cat')">Cats</span>, <span style="text-decoration: underline; cursor: pointer;" @click="selectSpecies('Bird')">Birds</span>, <span style="text-decoration: underline; cursor: pointer;" @click="selectSpecies('Guinea Pig')">Guinea Pigs</span>, <span style="text-decoration: underline; cursor: pointer;" @click="selectSpecies('Hamster')">Hamsters</span></h6>
    </div>
    <!-- <div class="q-pa-md row q-gutter-md justify-center text-center cards-container">
      <q-card class="my-card" @click="selectSpecies(null)"> All Pets </q-card>
      <q-card class="my-card" @click="selectSpecies('Dog')">
        <q-img
          src="https://hips.hearstapps.com/hmg-prod/images/golden-retriever-royalty-free-image-506756303-1560962726.jpg?crop=1.00xw:0.756xh;0,0.0756xh&resize=1200:*"
        >
        </q-img>
        <q-card-section class="text-center" style="font-weight: bold">
          Dogs
        </q-card-section>
      </q-card>

      <q-card class="my-card" @click="selectSpecies('Cat')">
        <q-img
          src="https://hips.hearstapps.com/hmg-prod/images/cute-cat-photos-1593441022.jpg"
        >
        </q-img>
        <q-card-section class="text-center" style="font-weight: bold">
          Cats
        </q-card-section>
      </q-card>

      <q-card class="my-card" @click="selectSpecies('Bird')">
        <q-img src="https://www.tracyvets.com/files/Parakeets.jpeg"> </q-img>
        <q-card-section class="text-center" style="font-weight: bold">
          Birds
        </q-card-section>
      </q-card>

      <q-card class="my-card" @click="selectSpecies('Guinea Pig')">
        <q-img
          src="https://squeaksandnibbles.com/wp-content/uploads/2017/05/Girl-guinea-pig-names-SN-long.jpg"
        >
        </q-img>
        <q-card-section class="text-center" style="font-weight: bold">
          Guinea Pigs
        </q-card-section>
      </q-card>

      <q-card class="my-card" @click="selectSpecies('Hamster')">
        <q-img
          src="https://www.thefactsite.com/wp-content/uploads/2016/03/cute-hamster-facts.jpg"
        >
        </q-img>
        <q-card-section class="text-center" style="font-weight: bold">
          Hamsters
        </q-card-section>
      </q-card>
    </div> -->
  </div>
  <div class="q-pa-md row q-gutter-md justify-left text-center pets-container">
    <div v-for="pet in filteredPets" :key="pet.petId">
      <q-card class="listing-card" flat bordered>
        <!-- <img
            v-for="photo in petPhotos[pet.petId]"
            :key="photo"
            :src="photo"
            alt="Photos of this Pet"
          /> -->

        <!-- <q-carousel animated v-model="slide" arrows navigation infinite>
            <q-carousel-slide
              v-for="photo in petPhotos[pet.petId]"
              :name="1"
              :key="photo"
              :img-src="photo"
            ></q-carousel-slide>
          </q-carousel> -->
        <img
          v-for="photo in petPhotos[pet.petId]"
          :key="photo"
          :src="photo"
          style="height: 300px; width:500px; object-fit: fill"
        />

        <q-list>
          <q-item>
            <q-item-section>
              <q-item-label class="text-weight-bold">Name:</q-item-label>
            </q-item-section>
            <q-item-section>
              <q-item-label>{{ pet.petName }}</q-item-label>
            </q-item-section>
          </q-item>
          <q-separator />
          <q-item>
            <q-item-section>
              <q-item-label class="text-weight-bold">Species: </q-item-label>
            </q-item-section>
            <q-item-section>
              <q-item-label>{{ pet.species }}</q-item-label>
            </q-item-section>
          </q-item>
          <q-separator />
          <q-item>
            <q-item-section>
              <q-item-label class="text-weight-bold">Breed: </q-item-label>
            </q-item-section>
            <q-item-section>
              <q-item-label>{{ pet.breed }}</q-item-label>
            </q-item-section>
          </q-item>
          <q-separator />
          <q-item>
            <q-item-section>
              <q-item-label class="text-weight-bold">Description:</q-item-label>
            </q-item-section>
            <q-item-section>
              <q-item-label>{{ pet.description }}</q-item-label>
            </q-item-section>
          </q-item>
        </q-list>
      </q-card>
    </div>
  </div>
</template>

<script>
import petservice from "../boot/PetService";
import { ref } from "vue";

export default {
  //test push
  name: "view-pets",
  data() {
    return {
      slide: ref(1),
      selectedSpecies: null,
      petPhotos: {},
      searchQuery: "",
      options: ["Dog", "Cat", "Bird", "Guiena Pig", "Hamster"],
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
        this.$store.commit("SET_PET_PHOTOS", {
          petId: petId,
          photos: response.data,
        });
        this.petPhotos[petId] = response.data;
      });
    },
    selectSpecies(species) {
      this.selectedSpecies = species;
    },
  },
  computed: {
    pets() {
      return this.$store.state.pets;
    },
    filteredPets() {
      let pets = this.$store.state.pets;
      if (this.selectedSpecies) {
        pets = pets.filter((pet) => pet.species === this.selectedSpecies);
      }
      if (this.searchQuery) {
        pets = pets.filter(
          (pet) =>
            pet.breed.toLowerCase().includes(this.searchQuery.toLowerCase()) ||
            pet.petName
              .toLowerCase()
              .includes(this.searchQuery.toLowerCase()) ||
            pet.species.toLowerCase().includes(this.searchQuery.toLowerCase())
        );
      }
      if (this.searchTerm) {
        pets = pets.filter((pet) =>
          pet.name.toLowerCase().includes(this.searchTerm.toLowerCase())
        );
      }
      return pets;
    },
  },
};
</script>
