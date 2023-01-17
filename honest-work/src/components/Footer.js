import React from 'react';
import { Link } from 'react-router-dom';
import "./Footer.css";


function Footer() {
    return (
      <div class="main-footer">
        <div class="container">
          <div class="row">
            {/* Column1 */}
            <div class="col">
              <h4>Team Solutions</h4>
              <ui class="list-unstyled">
                <li>312-943-3800</li>
                <li>Chicago, Illinois</li>
                <li>600 North State Street</li>
              </ui>
            </div>
            {/* Column2 */}
            <div class="col">
              <h4>Employers</h4>
              <ui class="list-unstyled">
                <li>Get a Free Employer Account</li>
                <li>Employer Center</li>
                <li>Advertise Projects</li>
              </ui>
            </div>
            {/* Column3 */}
            <div class="col">
              <h4>Work With Us</h4>
              <ui class="list-unstyled">
                <li>Advertisers</li>
                <li>Developers</li>
                <li>Career</li>
              </ui>
            </div>
          </div>
          <hr />
          <div class="row">
            <p class="col-sm">
              &copy;{new Date().getFullYear()} Team Solutions | All rights reserved |
              <Link to="/tos">Terms of Service</Link> | <Link to="privacy">Privacy</Link>
            </p>
          </div>
        </div>
      </div>
    );
  }
  
  export default Footer;