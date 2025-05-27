const BASE_URL = 'http://localhost:8080';

export async function apiFetch<T>(path: string, options: RequestInit = {}): Promise<T> {
    const response = await fetch(`${BASE_URL}${path}`, {
        headers: {
            'Content-Type': 'application/json',
            ...(options.headers || {}),
        },
        ...options,
    });

    let responseData: any = null;
    try {
        responseData = await response.json();
    } catch (err) {
        console.log(err);
    }

    if (!response.ok) {
        throw responseData || {message: 'Nieznany błąd serwera'};
    }

    return responseData;
}
