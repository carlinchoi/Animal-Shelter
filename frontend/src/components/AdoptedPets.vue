<template>
  <div id="q-app">
    <div style="margin-top: 4%;">
      <h3 class="text-center" style="font-weight: bold">
        Celebrate Our Adopted Pets!
      </h3>
    </div>
    <div class="q-flex q-justify-center">
      <div class="q-gutter-md">
        <q-toolbar class="q-toolbar--justify-center">
          <q-input
            v-model="searchQuery"
            type="text"
            label="Search our Adopted Pets by Name, Species, or Breed"
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

    <div
      class="search-container text-center"
      style="font-weight: bold; margin: 0"
    >
      <h6>
        Search by Category:
        <span
          style="text-decoration: underline; cursor: pointer"
          @click="selectSpecies(null)"
          >All Pets</span
        >,
        <span
          style="text-decoration: underline; cursor: pointer"
          @click="selectSpecies('Dog')"
          >Dogs</span
        >,
        <span
          style="text-decoration: underline; cursor: pointer"
          @click="selectSpecies('Cat')"
          >Cats</span
        >,
        <span
          style="text-decoration: underline; cursor: pointer"
          @click="selectSpecies('Bird')"
          >Birds</span
        >,
        <span
          style="text-decoration: underline; cursor: pointer"
          @click="selectSpecies('Guinea Pig')"
          >Guinea Pigs</span
        >,
        <span
          style="text-decoration: underline; cursor: pointer"
          @click="selectSpecies('Hamster')"
          >Hamsters</span
        >
      </h6>
    </div>
  </div>
  <div class="q-pa-md row q-gutter-md justify-left text-center pets-container">
    <div v-for="pet in filteredPets" :key="pet.petId">
      <q-card class="listing-card" flat bordered>
        <img
          v-for="photo in petPhotos[pet.petId]"
          :key="photo"
          :src="photo"
          style="height: 300px; width: 100%; object-fit: fill"
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
  name: "view-adoptions",
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
      petservice.findAdoptedPets().then((response) => {
        this.$store.commit("SET_ADOPTIONS_INFO", response.data);
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
      return this.$store.state.adoptedPets;
    },
    filteredPets() {
      let adoptedPets = this.$store.state.adoptedPets;
      if (this.selectedSpecies) {
        adoptedPets = adoptedPets.filter(
          (pet) => pet.species === this.selectedSpecies
        );
      }
      if (this.searchQuery) {
        adoptedPets = adoptedPets.filter(
          (pet) =>
            pet.breed.toLowerCase().includes(this.searchQuery.toLowerCase()) ||
            pet.petName
              .toLowerCase()
              .includes(this.searchQuery.toLowerCase()) ||
            pet.species.toLowerCase().includes(this.searchQuery.toLowerCase())
        );
      }
      if (this.searchTerm) {
        adoptedPets = adoptedPets.filter((pet) =>
          pet.name.toLowerCase().includes(this.searchTerm.toLowerCase())
        );
      }
      return adoptedPets;
    },
  },
};
</script>
