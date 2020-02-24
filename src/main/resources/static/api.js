function createNode(element) {
    return document.createElement(element); // Create the type of element you pass in the parameters
}

function append(parent, el) {
    return parent.appendChild(el); // Append the second parameter(element) to the first one
}


const os = document.getElementById('savenewoffers');

fetch("/api/savenewoffers")
    .then((resp) => resp.json()) // Transform the data into json
    .then(function (data) {

        // Map through the results and for each run the code below
        let li = createNode('li'), //  Create the elements we need
            span = createNode('span');
        li.innerHTML = `${data}`; // Make the HTML of our span to be the first and last name of our author
        append(li, span);
        append(os, li);

    });

const oc = document.getElementById('offerscount');

fetch("api/online/offerscount")
    .then((resp) => resp.json()) // Transform the data into json
    .then(function (data) {

        // Map through the results and for each run the code below
        let li = createNode('li'), //  Create the elements we need
            span = createNode('span');
        li.innerHTML = `${data}`; // Make the HTML of our span to be the first and last name of our author
        append(li, span);
        append(oc, li);

    });


const oo = document.getElementById('offersonline');

fetch("api/online/offers")
    .then((resp) => resp.json()) // Transform the data into json
    .then(function (data) {
        let offers = data; // Get the results
        return offers.map(function (offer) { // Map through the results and for each run the code below
            let li = createNode('li'), //  Create the elements we need
                span = createNode('span');
            li.innerHTML = `${offer} `; // Make the HTML of our span to be the first and last name of our author
            append(li, span);
            append(oo, li);
        })
    });


const ul = document.getElementById('offers');

fetch("api/db/offers")
    .then((resp) => resp.json()) // Transform the data into json
    .then(function (data) {
        let offers = data; // Get the results
        return offers.map(function (offer) { // Map through the results and for each run the code below
            let li = createNode('li'), //  Create the elements we need
                span = createNode('span');
            li.innerHTML = ` <a href="${offer.url}" target=”_blank”>  ${offer.name}  </a> Data zapisu do bazy: ${offer.dateTime}`; // Make the HTML of our span to be the first and last name of our author
            append(li, span);
            append(ul, li);
        })
    });
