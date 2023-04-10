<template>
  <div>
      <table>
          <thead>
              <tr>
                  <th>Pet</th>
              </tr>
          </thead>
          <tbody>
              <tr v-for="petInfo in this.$store.state.petInfo" :key="petInfo.PetId">
                  <td>{{ petInfo.breed }}</td>      
              </tr>
          </tbody>
      </table>
  </div>
</template>

<script>
export default {

}
</script>

<style>

</style>