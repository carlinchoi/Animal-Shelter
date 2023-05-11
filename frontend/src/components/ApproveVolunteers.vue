<template>
  <div id="q-app" style="min-height: 100vh">
    <div class="q-pa-md">
      <div>
        <h2 style="margin-bottom: 0.5rem; margin-top: 3%">Volunteers List</h2>
        <div>
          <q-input
            v-model="searchTerm"
            outlined
            label="Search Volunteers by First or Last Name"
            clearable
          />
        </div>
        <q-table
          class="my-sticky-header-table"
          flat
          bordered
          :rows="filteredVolunteers"
          :columns="columns"
          row-key="volunteer.email"
        >
          <template v-slot:body-cell-role="props">
            <q-td :props="props">
              <CustomQSelect :volunteer="props.row" />
            </q-td>
          </template>
        </q-table>
      </div>
    </div>
  </div>
</template>

<script>
import VolunteerService from "../boot/VolunteerService.js";
import CustomQSelect from "./CustomQSelect.vue";
export default {
  name: "view-volunteers",
  components: {
    CustomQSelect,
  },
  data() {
    return {
      searchTerm: "",
      columns: [
        {
          name: "firstName",
          label: "First Name",
          field: "firstName",
          align: "left",
        },
        {
          name: "lastName",
          label: "Last Name",
          field: "lastName",
          align: "left",
        },
        { name: "email", label: "Email", field: "email", align: "left" },
        { name: "phone", label: "Phone", field: "phone", align: "left" },
        {
          name: "role",
          label: "Role",
          field: "role",
          sortable: false,
          align: "left",
        },
      ],
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
    updateStatus(volunteer) {
      VolunteerService.updateVolunteerStatus(volunteer).then((response) => {
        this.$store.commit("SET_PENDING_VOLUNTEER_INFO", response.data);
        this.retrieveVolunteers();
      });
    },
  },
  computed: {
    volunteers() {
      return this.$store.state.pendingVolunteers;
    },
    filteredVolunteers() {
      let filtered = this.volunteers;
      if (this.searchTerm) {
        filtered = filtered.filter(
          (volunteer) =>
            volunteer.firstName
              .toLowerCase()
              .includes(this.searchTerm.toLowerCase()) ||
            volunteer.lastName
              .toLowerCase()
              .includes(this.searchTerm.toLowerCase())
        );
      }
      return filtered;
    },
  },
  created() {
    this.retrieveVolunteers();
  },
};
</script>
