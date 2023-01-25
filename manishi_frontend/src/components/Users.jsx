import FetchAllUsers from '../hooks/GetAllUsers.jsx'

const Users = () => {
	
	
	let users = FetchAllUsers()
	
	return (
		<div>
			{
				users != null &&
				users.map(u => <p key={u.username}>{u.username}</p>)
			}
		</div>
	)
}

export default Users
