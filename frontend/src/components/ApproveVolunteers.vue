<template>
  <div id="q-app" style="min-height: 100vh">
    <div class="q-pa-md">
      <q-table
        class="my-sticky-header-table"
        flat
        bordered
        title="Volunteers List"
        :rows="filteredVolunteers"
        :columns="columns"
        row-key="id"
      >
        <template v-slot:top-right>
          <q-input
            borderless
            dense
            debounce="300"
            v-model="searchTerm"
            placeholder="Search"
          >
            <template v-slot:append>
              <q-icon name="search"></q-icon>
            </template>
          </q-input>
        </template>
        <template v-slot:body-status="props">
          <q-select
            v-model="props.row.status"
            :options="statusOptions"
            @input="updateStatus(props.row)"
          />
        </template>
      </q-table>
    </div>
  </div>
</template>

<script>
import VolunteerService from "../boot/VolunteerService.js";

export default {
  name: "view-volunteers",
  data() {
    return {
      searchTerm: "",
      selectedRole: null,
      columns: [
        {
          name: "firstName",
          required: true,
          label: "First Name",
          align: "left",
          field: "firstName",
          sortable: true,
        },
        {
          name: "lastName",
          required: true,
          label: "Last Name",
          align: "left",
          field: "lastName",
          sortable: true,
        },
        {
          name: "email",
          required: true,
          label: "Email",
          align: "left",
          field: "email",
          sortable: true,
        },
        {
          name: "phone",
          required: true,
          label: "Phone",
          align: "left",
          field: "phone",
          sortable: true,
        },
        {
          name: "role",
          required: true,
          label: "Role",
          align: "left",
          field: "role",
          sortable: true,
        },
        {
          name: "status",
          required: false,
          label: "Status",
          align: "left",
          field: "status",
          sortable: false,
        },
      ],
      statusOptions: [
        { label: "Pending", value: "pending" },
        { label: "Approved", value: "approved" },
        { label: "Declined", value: "declined" },
      ],
    };
  },
  methods: {
    retrieveVolunteers() {
      VolunteerService.findAllPendingVolunteer().then((response) => {
        this.$store.commit("SET_VOLUNTEER_INFO", response.data);
      });
    },
    updateStatus(volunteer, event) {
      volunteer.status = event;
      VolunteerService.updateVolunteerStatus(volunteer).then((response) => {
        this.$store.commit("SET_VOLUNTEER_INFO", response.data);
        this.retrieveVolunteers();
      });
    },
  },
  computed: {
    volunteers() {
      return this.$store.state.volunteers;
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
              .includes(this.searchTerm.toLowerCase()) ||
            volunteer.email
              .toLowerCase()
              .includes(this.searchTerm.toLowerCase()) ||
            volunteer.phone
              .toLowerCase()
              .includes(this.searchTerm.toLowerCase())
        );
      }

      if (this.selectedRole) {
        filtered = filtered.filter(
          (volunteer) => volunteer.role === this.selectedRole
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
