export type AttributeKey =
    | "WS" | "BS" | "S" | "T" | "I"
    | "AG" | "DEX" | "INT" | "WP" | "FEL"
    | "W" | "M";

export interface AttributeInfo {
    label: string;
    short: string;
}

export const attributeMap: Record<AttributeKey, AttributeInfo> = {
    WS: { label: "Walka Wręcz", short: "WW" },
    BS: { label: "Umiejętności Strzeleckie", short: "US" },
    S: { label: "Siła", short: "S" },
    T: { label: "Wytrzymałość", short: "Wt" },
    I: { label: "Inicjatywa", short: "I" },
    AG: { label: "Zwinność", short: "Zw" },
    DEX: { label: "Zręczność", short: "Zr" },
    INT: { label: "Inteligencja", short: "Int" },
    WP: { label: "Siła Woli", short: "SW" },
    FEL: { label: "Ogłada", short: "Ogd" },
    W: { label: "Żywotność", short: "Żyw" },
    M: { label: "Szybkość", short: "Sz" },
};

export function formatAttribute(attr: AttributeKey, type: keyof AttributeInfo = 'label'): string {
    return attributeMap[attr]?.[type] || attr;
}

export function getAttributeOptions(): { value: AttributeKey; label: string }[] {
    return Object.entries(attributeMap).map(([value, { label }]) => ({
        value: value as AttributeKey,
        label,
    }));
}