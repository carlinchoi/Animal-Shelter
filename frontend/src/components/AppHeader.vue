<template>
  <q-header class="text-black bg-white" elevated>
    <q-toolbar>
      <q-avatar>
        <img
          src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTet9ewjLhjRL3uQUvKqGCeIdZqreI1Csmxow&usqp=CAU"
        />
      </q-avatar>

      <q-toolbar-title>Rockville Animal Shelter</q-toolbar-title>

      <q-tabs v-model="tab" class="q-tabs-centered">
        <q-route-tab
          name="homeRoute"
          label="Home"
          :to="{ name: 'homePage' }"
        ></q-route-tab>
        |
        <q-route-tab
          name="adoptedPetsRoute"
          label="Our Adopted Pets"
          :to="{ name: 'adoptedPets' }"
        ></q-route-tab>
        |
        <q-route-tab
          name="addNewPetRoute"
          label="Add New Pet Listing"
          :to="{ name: 'addNewPet' }"
        ></q-route-tab>
        |
        <q-route-tab
          name="volunteerRegistrationRoute"
          label="Become a Volunteer"
          class="q-tab-with-margin"
          :to="{ name: 'VolunteerRegister' }"
        ></q-route-tab>
      </q-tabs>

      <q-btn color="primary" label="Account" v-if="isLoggedIn">
        <q-menu>
          <q-list dense style="min-width: 100px">
            <q-item
              clickable
              v-close-popup
              :to="{ name: 'ViewVolunteers' }"
              v-if="isVolunteerOrAdmin"
            >
              <q-item-section>View Volunteers</q-item-section>
            </q-item>
            <q-item
              clickable
              v-close-popup
              :to="{ name: 'ApproveVolunteers' }"
              v-if="isAdmin"
            >
              <q-item-section>Approve Pending Volunteers</q-item-section>
            </q-item>
            <q-separator></q-separator>
            <q-item
              clickable
              @click="logout"
              v-close-popup
              :to="{ name: 'homePage' }"
            >
              <q-item-section>Log Out</q-item-section>
            </q-item>
          </q-list>
        </q-menu>
      </q-btn>
      <q-btn
        color="primary"
        label="Sign In"
        v-if="!isLoggedIn"
        :to="{ name: 'loginPage' }"
      />
    </q-toolbar>
  </q-header>
</template>

<script>
import { mapMutations } from "vuex";

export default {
  name: "AppHeader",
  computed: {
    isLoggedIn() {
      if (this.$store.state.user.authorities != null)
        return (
          this.$store.state.user.authorities[0].name.includes(
            "ROLE_VOLUNTEER"
          ) ||
          this.$store.state.user.authorities[0].name.includes("ROLE_ADMIN") ||
          this.$store.state.user.authorities[0].name.includes("ROLE_USER")
        );
      else {
        return false;
      }
    },
    isVolunteerOrAdmin() {
      if (this.$store.state.user.authorities != null)
        return (
          this.$store.state.user.authorities[0].name.includes(
            "ROLE_VOLUNTEER"
          ) || this.$store.state.user.authorities[0].name.includes("ROLE_ADMIN")
        );
      else {
        return false;
      }
    },
    isAdmin() {
      if (this.$store.state.user.authorities != null)
        return this.$store.state.user.authorities[0].name.includes(
          "ROLE_ADMIN"
        );
      else {
        return false;
      }
    },
  },
  methods: {
    ...mapMutations(["LOGOUT"]),
    logout() {
      this.LOGOUT();
    },
  },
  data() {
    return {
      tab: "images",
    };
  },
};
</script>
