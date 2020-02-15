function createNode(element) {
    return document.createElement(element); // Create the type of element you pass in the parameters
}

function append(parent, el) {
    return parent.appendChild(el); // Append the second parameter(element) to the first one
}

const ul = document.getElementById('offers');

fetch("api/db/offers")
    .then((resp) => resp.json()) // Transform the data into json
    .then(function (data) {
        let offers = data; // Get the results
        return offers.map(function (offer) { // Map through the results and for each run the code below
            let li = createNode('li'), //  Create the elements we need
                span = createNode('span');
            li.innerHTML = `${offer.name} ${offer.url}`; // Make the HTML of our span to be the first and last name of our author
            append(li, span);
            append(ul, li);
        })
    })

