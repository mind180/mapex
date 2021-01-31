/**
 * Make fetch request with specific method to url with passed entities in body
 * 
 * @param {String} method   POST, PUT, PATCH, DELETE
 * @param {String} url      pass to etities
 * @param {Array}  entities optional 
 */
export async function processEntity(method, url, entities) {
  return fetch(url, {
    method: method,
    headers: { 'Content-Type': 'application/json' },
    body: JSON.stringify(entities)
  })
    .then(response => handleResponse(response));
}

async function handleResponse(response) {
  if (response.ok) {
    return response;
  }
  const error = await response.json();
  return await Promise.reject(error);
}
