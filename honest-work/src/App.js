import React, { Component } from 'react';
import { BrowserRouter, Route, Switch } from 'react-router-dom';
import "./App.css";

import Home from './components/home/Home';
import Register from './components/home/Register';
import Project from './components/project/Project';
import Feedback from './components/feedback/Feedback';
import Settings from './components/settings/Settings';
import Header from './components/Header';
import Footer from './components/Footer';
import Leaderboard from './components/feedback/Leaderboard';
import ToS from './components/legal/ToS';
import Privacy from './components/legal/Privacy';
import Error from './components/Error';


import { GlobalProvider } from './context/GlobalState';




class App extends Component {
  render() {
    return (
      //Routes the different pages to their paths
      <div className="page-container">
        <GlobalProvider>
          <BrowserRouter>
            <Header />
            <div className="content-wrap">
              <div>
                <Switch>
                  <Route path="/" component={Home} exact />
                  <Route path="/project" component={Project} exact />
                  <Route path="/settings" component={Settings} exact />
                  <Route path="/feedback" component={Feedback} exact />
                  <Route path="/leaderboard" component={Leaderboard} exact />
                  <Route path="/register" component={Register} exact />
                  <Route path="/tos" component={ToS} exact />
                  <Route path="/privacy" component={Privacy} exact />
                  <Route component={Error} />
                  
                </Switch>
              </div>
            </div>
            <Footer />
          </BrowserRouter>
        </GlobalProvider>
      </div>
    );
  }
}



export default App;

