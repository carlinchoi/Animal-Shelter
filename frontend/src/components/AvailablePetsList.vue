<template>
  <div class="q-pa-md row q-gutter-md justify-left text-center">
    <div v-for="pet in filteredPets" :key="pet.petId">
      <q-card class="listing-card" flat bordered>
        <q-carousel animated v-model="slide" arrows navigation infinite>
          <q-carousel-slide
            v-for="photo in petPhotos[pet.petId]"
            :name="1"
            :key="photo"
            :img-src="photo"
          ></q-carousel-slide>
        </q-carousel>
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
      slide: 1,
      selectedSpecies: null,
      petPhotos: {},
      searchQuery: "",
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
