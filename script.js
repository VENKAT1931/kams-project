function createAccount() {
    fetch("http://localhost:8080/accounts", {
        method: "POST",
        headers: {"Content-Type": "application/json"},
        body: JSON.stringify({
            companyName: document.getElementById("company").value,
            industry: document.getElementById("industry").value,
            healthScore: 90,
            stage: "Active"
        })
    }).then(() => alert("Account Created"));
}

function createContract() {
    fetch("http://localhost:8080/contracts", {
        method: "POST",
        headers: {"Content-Type": "application/json"},
        body: JSON.stringify({
            title: document.getElementById("title").value,
            contractValue: document.getElementById("value").value,
            startDate: "2025-01-01",
            endDate: "2026-01-01",
            account: { id: 1 }
        })
    }).then(() => alert("Contract Created"));
}

function loadDashboard() {
    fetch("http://localhost:8080/dashboard")
    .then(res => res.json())
    .then(data => {
        document.getElementById("revenue").innerText = data.totalRevenue;
        document.getElementById("active").innerText = data.activeContracts;
        document.getElementById("expired").innerText = data.expiredContracts;
    });
}