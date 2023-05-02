<template>
  <q-layout>
    <q-page-container class="q-gutter-md">
      <q-page class="add-wrapper">
        <div class="form-wrapper">
          <q-form @submit.prevent="addNewPet" ref="addPetForm">
            <div class="my-inputs">
              <q-card class="my-card">
                <q-card-section class="bg-primary text-white text-center">
                  <div class="text-h6">Add New Pet Listing Form</div>
                </q-card-section>
              </q-card>
              <q-input
                filled
                v-model="pet.petName"
                label="Name"
                type="text"
                required
              />
              <q-select
                filled
                v-model="pet.species"
                label="Select Species"
                :options="breedOptions"
                required
              />
              <q-option-group
                v-model="pet.gender"
                label="Gender"
                type="radio"
                :options="genderOptions"
                required
                inline
                align="left"
              />
              <q-input
                filled
                v-model="pet.breed"
                label="Breed"
                type="text"
                required
              />
              <q-input
                filled
                v-model="pet.age"
                label="Age"
                type="number"
                required
              />
              <q-input
                filled
                v-model="pet.description"
                label="Description"
                type="text"
                required
              />
              <q-input
                filled
                v-model="pet.petPhoto"
                label="Photo URL"
                type="url"
                required
              />
              <q-btn
                type="submit"
                class="q-mt-md"
                label="Submit New Listing"
                color="primary"
              />
            </div>
          </q-form>
        </div>
      </q-page>
    </q-page-container>
  </q-layout>
</template>

<script>
import petService from "../boot/PetService.js";
export default {
  name: "addPetListing",
  data() {
    return {
      pet: {
        petName: "",
        species: "",
        gender: "",
        breed: "",
        age: "",
        description: "",
        isAdopted: false,
        petPhoto: "",
      },
      breedOptions: ["Dog", "Cat", "Bird", "Guinea Pig", "Hamster"],
      genderOptions: [
        { label: "Male", value: "male" },
        { label: "Female", value: "female" },
      ],
    };
  },
  methods: {
    addNewPet() {
      const form = this.$refs.addPetForm;
      petService
        .createPet(this.pet)
        .then((response) => {
          if (response.status == 200) {
            this.$router.push({
              path: "/",
              query: { registration: "success" },
            });
          }
        })
        .catch((error) => {
          const response = error.response;
          this.registrationErrors = true;
          if (response.status === 400) {
            this.registrationErrorMsg = "Bad Request: Validation Errors";
          }
        });
    },
  },
};
</script>
