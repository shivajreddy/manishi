import { useEffect, useState } from 'react'
import axios from 'axios'

function CreateNewUser (username, password) {
	
	const baseUrl = 'http://localhost:8080'
	const demoUrl = baseUrl + '/demo'
	const usersUrl = baseUrl + '/users'
	
	// const [data, setData] = useState(null)
	// let users = null
	const [users, setUsers] = useState(null)
	
	useEffect(() => {
		
		axios.post(
			usersUrl,
			{
				'username': username,
				'password': password,
			},
		).then(res => setUsers(res.data))
		
	}, [usersUrl])
	
	return users
}

