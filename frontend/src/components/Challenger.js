import React, { useEffect, useState } from 'react'

function Challenger() {
  const [ChallengerPlayers, setChallengerPlayers] = useState([])
  
  useEffect(() => {
    fetch("/league/challenger")
    .then(res => {
      return res.json()
    })
    .then(data => {
      console.log(data)
      setChallengerPlayers(data)
    })
    .catch((err) =>
    console.log(err))
  }, [])


  return (
    <div>
      <h1>Challenger League</h1>
      {ChallengerPlayers.map(challengerPlayer => (
        <ul key={challengerPlayer.summonerId}>
          <li>
            <div className="challenger-block">
            {challengerPlayer.summonerName}
            {challengerPlayer.leaguePoints}
            </div>
          </li>
        </ul>
      ))}
    </div>
  )
}

export default Challenger
