<template>
  <q-select
    v-model="role"
    :options="roles"
    outlined
    dense
    v-on:update:model-value="updateStatus(role)"
  />
</template>

<script>
import VolunteerService from "../boot/VolunteerService.js";
export default {
  name: "CustomQSelect",
  props: ["volunteer"],
  data() {
    return {
      role: this.volunteer.role,
      roles: [
        { label: "Pending", value: "ROLE_PENDINGVOLUNTEER" },
        { label: "Approved", value: "ROLE_APPROVED" },
        { label: "Declined", value: "ROLE_DECLINED" },
      ],
    };
  },
  methods: {
    retrieveVolunteers() {
      VolunteerService.findAllPendingVolunteer().then((response) => {
        this.$store.commit("SET_PENDING_VOLUNTEER_INFO", response.data);
      });
    },
    updateStatus(role) {
      var finalVolunteer = { ...this.volunteer };
      finalVolunteer.role = role.value;
      VolunteerService.updateVolunteerStatus(finalVolunteer).then(
        (response) => {
          this.$store.commit("SET_PENDING_VOLUNTEER_INFO", response.data);
          this.retrieveVolunteers();
        }
      );
    },
  },
};
</script>
