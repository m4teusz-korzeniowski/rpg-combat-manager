const attributeMap = {
    WS: {label: 'Walka Wręcz', short: 'WW'},
    BS: {label: 'Umiejętności Strzeleckie', short: 'US'},
    S: {label: 'Siła', short: 'S'},
    T: {label: 'Wytrzymałość', short: 'Wt'},
    I: {label: 'Inicjatywa', short: 'I'},
    AG: {label: 'Zwinność', short: 'Zw'},
    DEX: {label: 'Zręczność', short: 'Zr'},
    INT: {label: 'Inteligencja', short: 'Int'},
    WP: {label: 'Siła Woli', short: 'SW'},
    FEL: {label: 'Ogłada', short: 'Ogd'},
    W: {label: 'Żywotność', short: 'Żyw'},
    M: {label: 'Szybkość', short: 'Sz'},
};

export function formatAttribute(attr, type = 'label') {
    return attributeMap[attr]?.[type] || attr;
}

export function getAttributeOptions() {
    return Object.entries(attributeMap).map(([value, { label }]) => ({
        value,
        label,
    }));
}

export { attributeMap };