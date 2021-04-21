<template>
  <input v-model="username" type="text" placeholder="username">
  <input v-model="password" type="password" placeholder="password">
  <button @click="login">Login</button>
</template>

<script>
export default {
  data() {
    return {
      username: '',
      password: ''
    }
  },

  methods: {
    async login() {
      let credentials = {
        username: this.username,
        password: this.password
      }

      let user = await fetch('/rest/login', {
        method: 'POST',
        headers: {'content-type': 'application/json'},
        body: JSON.stringify(credentials)
      })
      
      console.log(await user.json())

      this.username = ''
      this.password = ''
    }
  },

  async mounted() {
    let user = await fetch('/rest/whoami')
    if(user.ok) {
      user = await user.json()
      console.log(user)
    }
  }
}
</script>

<style>

</style>