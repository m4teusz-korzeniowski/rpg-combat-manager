const BASE_URL = 'http://localhost:8080';

export async function apiFetch(path, options = {}) {
    const response = await fetch(`${BASE_URL}${path}`, {
        headers: {
            'Content-Type': 'application/json',
            ...(options.headers || {}),
        },
        ...options,
    });

    let responseData = null;
    try {
        responseData = await response.json();
    } catch (err) {
    }

    if (!response.ok) {
        throw responseData || {message: 'Nieznany błąd serwera'};
    }

    return responseData;
}
