import './App.css';
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom';
import NavBar from './components/NavBar'
import Summoner from './components/Summoner'
import Challenger from './components/Challenger'
import Home from './Pages/Home'

function App() {
  return (
    <Router>
      <div className="App">
        <NavBar />
        <Switch>
          <Route exact path="/challenger">
            <Challenger />
          </Route>
          <Route exact path="/summoner/:summonerName">
            <Summoner />
          </Route>
          <Route exact path="/">
            <Home />
          </Route>
        </Switch>
      </div>
    </Router>
  );
}

export default App;
