import React, { useState, useContext } from 'react';
import { useHistory  } from 'react-router-dom';
import { GlobalContext } from '../../context/GlobalState.js';

export const Privacy = () => {
  return (
      <div class="paragraph">
        <header>
    <h1>TEAM SOLUTIONS Privacy Policy</h1>
    </header>

   <nav>
    <h1 id="contents">Contents</h1>

     <ul>
     <li><a href="#personal-info">Personal info</a>
      
      </li>
     
     <li><a href="#collection">Collection</a>
      <ul><li><a href="#collection_tracking">Tracking technologies</a></li></ul>
      </li>
      
     <li><a href="#use">Use</a>
      </li>
    
     <li><a href="#disclosure">Disclosure</a>
      <ul>
       <li><a href="#disclosure_partners">Partners</a></li>
       <li><a href="#disclosure_legal">Legal process</a></li>
       </ul></li>
      
     <li><a href="#storage">Storage</a>
      <ul>
       <li><a href="#storage_location">Where your info lives</a></li>
       <li><a href="#storage_duration">How long we keep your info</a></li>
       </ul></li>
      
    <li><a href="#misc">About</a>
     <ul><li><a href="#choice">Your choices</a></li>
      <li><a href="#change">Changes to this policy</a></li>
      <li><a href="#contact">Contact us</a></li>
      </ul></li>
      
     </ul>
    </nav>
   
   <article>

    <nav class="to-top"><a href="#contents">back to top</a></nav>

    <section>

     <h1 id="personal-info">Personal info</h1>

    

     </section>
   
    <nav class="to-top"><a href="#contents">back to top</a></nav>
   
    <section>
    
     <h1 id="collection">How we collect info</h1>

      <h2 id="collection_tracking">Tracking technologies</h2>

     </section>

    <nav class="to-top"><a href="#contents">back to top</a></nav>

    <section>

     <h1 id="use">How we use your info</h1>

     </section>

    <nav class="to-top"><a href="#contents">back to top</a></nav>

    <section>

     <h1 id="disclosure">When we share your info</h1>

      <h2 id="disclosure_partners">Our Partners</h2>

      <h2 id="disclosure_legal">Legal process</h2>

     </section>

    <nav class="to-top"><a href="#contents">back to top</a></nav>

    <section>

     <h1 id="storage">How we store your info</h1>

      <h2 id="storage_location">Where your info lives</h2>

      <h2 id="storage_duration">How long we keep your info</h2>

     </section>

    <nav class="to-top"><a href="#contents">back to top</a></nav>

    <section>

     <h1 id="misc">About</h1>

      <h2 id="misc_choice">Your choices</h2>

      <h2 id="misc_changes">Changes</h2>

      <h2 id="misc_contact">Contact us</h2>

     </section>

    </article>

      </div>
  ); 
}
export default Privacy;