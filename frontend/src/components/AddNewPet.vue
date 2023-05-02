<template>
  <q-layout>
    <q-page-container class="q-gutter-md">
      <q-page class="add-wrapper">
        <div class="form-wrapper">
          <q-form @submit.prevent="addNewPet" ref="addPetForm">
            <div class="my-inputs">
              <h3
                style="font-weight: bold; margin-bottom: 1%; margin-top: 1%"
                align="left"
              >
                Add New Pet
              </h3>
              <q-separator />

              <div class="input-container">
                <p style="font-weight: bold; margin-bottom: 1%">Pet Name</p>

                <q-input
                  filled
                  v-model="pet.petName"
                  label="Pet Name"
                  type="text"
                  required
                  style="width: 100%"
                >
                  <template v-slot:prepend>
                    <q-icon name="pets" />
                  </template>
                </q-input>
              </div>
            </div>
            <div class="input-container">
              <p style="font-weight: bold; margin-bottom: 1%">Gender</p>
              <q-option-group
                v-model="pet.gender"
                type="radio"
                :options="genderOptions"
                required
                inline
                align="left"
              />
            </div>
            <div class="input-container">
              <p style="font-weight: bold; margin-bottom: 1%">Age</p>
              <q-input
                filled
                v-model="pet.age"
                label="Age"
                type="number"
                required
                style="width: 49%"
                min="0"
                max="100"
              >
                <template v-slot:prepend>
                  <q-icon name="event" />
                </template>
              </q-input>
            </div>

            <div class="input-container">
              <div class="form-row">
                <div class="input-container select">
                  <p style="font-weight: bold; margin-bottom: 1%">
                    Select Species
                  </p>
                  <q-select
                    filled
                    v-model="pet.species"
                    label="Select Species"
                    :options="breedOptions"
                    required
                    style="width: 100%"
                  >
                    <template v-slot:prepend>
                      <q-icon name="pets" />
                    </template>
                  </q-select>
                </div>
                <div class="input-container">
                  <p style="font-weight: bold; margin-bottom: 1%">Breed</p>

                  <q-input
                    filled
                    v-model="pet.breed"
                    label="Breed"
                    type="text"
                    style="width: 100%"
                    required
                  >
                    <template v-slot:prepend>
                      <q-icon name="flag" />
                    </template>
                  </q-input>
                </div>
              </div>

              <div class="input-container">
                <p style="font-weight: bold; margin-bottom: 1%">Description</p>
                <q-input
                  filled
                  v-model="pet.description"
                  label="Description"
                  type="text"
                  required
                  style="width: 100%"
                >
                  <template v-slot:prepend>
                    <q-icon name="description" />
                  </template>
                </q-input>
              </div>
              <div class="input-container">
                <p style="font-weight: bold; margin-bottom: 1%">Photo URL</p>
                <q-input
                  filled
                  v-model="pet.petPhoto"
                  label="Photo URL"
                  type="url"
                  required
                  style="width: 100%"
                >
                  <template v-slot:prepend>
                    <q-icon name="image" />
                  </template>
                </q-input>
              </div>
              <div
                class="input-container"
                style="display: flex; justify-content: space-between"
              >
                <q-btn
                  class="q-mt-md"
                  label="Cancel
"
                  color="negative"
                  @click="$router.push('/')"
                  size="lg"
                />
                <q-btn
                  type="submit"
                  class="q-mt-md"
                  label="Submit"
                  color="primary"
                  size="lg"
                  style="flex-grow: 0.97"
                />
              </div>
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
        { label: "Male", value: "Male" },
        { label: "Female", value: "Female" },
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
