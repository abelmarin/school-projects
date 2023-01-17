require("dotenv").config();
const express = require("express");
const app = express();
const db = require('./db');
const { Client } = require('pg');
const client = new Client({
  connectionString: process.env.DATABASE_URL,
  ssl: true,
});

/* client.connect();
client.query('SELECT table_schema,table_name FROM information_schema.tables;', (err, res) => {
  if (err) throw err;
  for (let row of res.rows) {
    console.log(JSON.stringify(row));
  }
  client.end();
}); */

// Express middleware
app.use(express.json());

// Get all Members
app.get("/api/v1/members", (req, res) => {
    db.query()
    console.log("route handler ran");
    res.status(200).json({
        status: "success",
        data: {
            member: ["philip", "dakota", "user321"],
        },
    });
});

// Get a Member
app.get("/api/v1/members/:id", (req, res) => {
    console.log(req.params);
    
    res.status(200).json({
        status: "success",
        data: {
            member: "johnWick"
        }
    });
});

// Create a Member
app.post("/api/v1/members", (req, res) => {
    console.log(req.body);
    res.status(201).json({
        status: "success",
        data: {
            member: "johnWick"
        }
    });
});

// Update Members
app.put("/api/v1/members/:id", (req, res) => {
    console.log(req.params.id);
    console.log(req.body);
    res.status(200).json({
        status: "success",
        data: {
            member: "johnWick"
        }
    });
});

// Delete a Member
app.delete("/api/v1/members/:id", (req, res) => {
    res.status(204).json({
        status: "success",
    });
});


const port = 3005
app.listen(port, () => {
    console.log(
        `server is up and listening on port ${port}`);
});