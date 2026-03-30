const BASE_URL = "https://kams-backend-b6cx.onrender.com";

// CREATE ACCOUNT
function createAccount() {
    fetch(`${BASE_URL}/accounts`, {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify({
            companyName: document.getElementById("company").value,
            industry: document.getElementById("industry").value,
            healthScore: 90,
            stage: "Active"
        })
    })
    .then(res => res.json())
    .then(() => alert("Account Created ✅"))
    .catch(err => console.error("Error:", err));
}

// CREATE CONTRACT
function createContract() {
    fetch(`${BASE_URL}/contracts`, {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify({
            title: document.getElementById("title").value,
            contractValue: parseFloat(document.getElementById("value").value),
            startDate: "2025-01-01",
            endDate: "2026-01-01",
            account: { id: 1 }
        })
    })
    .then(res => res.json())
    .then(() => alert("Contract Created ✅"))
    .catch(err => console.error("Error:", err));
}

// LOAD DASHBOARD
function loadDashboard() {
    fetch(`${BASE_URL}/dashboard`)
    .then(res => res.json())
    .then(data => {
        document.getElementById("revenue").innerText = data.totalRevenue;
        document.getElementById("active").innerText = data.activeContracts;
        document.getElementById("expired").innerText = data.expiredContracts;
    })
    .catch(err => console.error("Error:", err));
}