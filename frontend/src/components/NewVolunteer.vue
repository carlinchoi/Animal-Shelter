<template>
  <q-layout>
    <q-page-container class="q-gutter-md">
      <q-page class="register-wrapper">
        <div class="form-wrapper">
          <div id="register" class="text-center">
            <q-form @submit.prevent="submitForm" ref="registerForm">
              <div class="my-inputs">
                <h1 style="font-weight: bold; margin-bottom: 1%; margin-top: 1%">
                  Volunteer Application
                </h1>
                <q-separator />

                <div class="input-container">
                  <p style="font-weight: bold; margin-bottom: 1%">First Name</p>
                  <q-input
                    filled
                    v-model="firstName"
                    label="First Name"
                    type="text"
                    required
                    style="width: 100%"
                  >
                    <template #prepend>
                      <q-icon name="person-outline" />
                    </template>
                  </q-input>
                </div>
                <div class="input-container">
                  <p style="font-weight: bold; margin-bottom: 1%">Last Name</p>
                  <q-input
                    filled
                    v-model="lastName"
                    label="Last Name"
                    type="text"
                    required
                    style="width: 100%"
                  >
                    <template #prepend>
                      <q-icon name="person-outline" />
                    </template>
                  </q-input>
                </div>
                <div class="input-container">
                  <p style="font-weight: bold; margin-bottom: 1%">Email</p>
                  <q-input
                    filled
                    v-model="email"
                    label="Email"
                    type="email"
                    required
                    style="width: 100%"
                  >
                    <template #prepend>
                      <q-icon name="mail-outline" />
                    </template>
                  </q-input>
                </div>
                <div class="input-container">
                  <p style="font-weight: bold; margin-bottom: 1%">Phone Number</p>
                  <q-input
                    filled
                    v-model="phone"
                    label="Phone Number"
                    type="tel"
                    required
                    style="width: 100%"
                  >
                    <template #prepend>
                      <q-icon name="call-outline" />
                    </template>
                  </q-input>
                </div>
                <p> A confirmation email will be sent to you. </p>
                <div
                  class="input-container"
                  style="display: flex; justify-content: space-between"
                >
                  <q-btn
                    class="q-mt-md"
                    label="Cancel"
                    color="negative"
                    @click="$router.push('/')"
                    size="lg"
                    style="flex-grow: 0.97"
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
        </div>
      </q-page>
    </q-page-container>
  </q-layout>
</template>


<script>
import VolunteerService from "../boot/VolunteerService";
import emailService from "../boot/EmailService";

export default {
  data() {
    return {
      firstName: "",
      lastName: "",
      email: "",
      phone: "",
    };
  },
  props: ["username"],
  methods: {
    submitForm() {
      const volunteerApplication = {
        username: this.username,
        firstName: this.firstName,
        lastName: this.lastName,
        email: this.email,
        phone: this.phone,
      };
      console.log(volunteerApplication);
      const applicationEmail = {
        recipient: this.email,
        msgBody:
          "Thanks for applying! Your application is being reviewed by our administrators. Stand by for details!",
        subject: "Thank you from Rockville!",
      };
      VolunteerService.updateVolunteer(volunteerApplication)
        .then((response) => {
          if (response.status == 200) {
            emailService.sendEmail(applicationEmail).then((response) => {
              if (response.status == 200) {
                this.$router.push({
                  path: "/login",
                  query: { registration: "success" },
                });
              }
            });
          }
        })
        .catch((error) => {
          console.error("Error creating volunteer application:", error);
        });
    },
  },
};
</script>

<style>

</style>
