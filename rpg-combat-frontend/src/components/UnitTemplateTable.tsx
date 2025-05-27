import React from "react";
import { attributeMap, AttributeKey } from "../utils/attributeMapper";
import { UnitTemplateDto } from "../model/unitTemplate";

interface Props {
    unitTemplate: UnitTemplateDto;
}

export function UnitTemplateTable({ unitTemplate }: Props) {
    const attributeOrder: AttributeKey[] = Object.keys(attributeMap).filter(
        (k): k is AttributeKey => attributeMap[k as AttributeKey]?.short !== undefined
    );

    const getAttributeValue = (key: AttributeKey): number | string => {
        const found = unitTemplate.attributes.find(attr => attr.key === key);
        return found ? found.value : '';
    };

    return (
        <div className="container mt-3">
            <h5 className="fw-bold">{unitTemplate.name}</h5>

            <table className="table table-bordered text-center align-middle">
                <thead>
                <tr>
                    {attributeOrder.map((key) => (
                        <th key={key} className="fw-bold text-start">
                            {attributeMap[key].short}
                        </th>
                    ))}
                </tr>
                </thead>
                <tbody>
                <tr>
                    {attributeOrder.map((key) => (
                        <td key={key} className="text-start">
                            {getAttributeValue(key)}
                        </td>
                    ))}
                </tr>
                </tbody>
            </table>

            <div className="border p-3 mb-2">
                <strong><em>Umiejętności:</em></strong>{" "}
                {unitTemplate.skills
                    .map(skill =>
                        `${skill.name} (${attributeMap[skill.relatedAttribute as AttributeKey]?.short || skill.relatedAttribute}) +${skill.advances}`
                    )
                    .join(", ")}
            </div>

            <div className="border p-3">
                <strong><em>Zdolności:</em></strong>{" "}
                {unitTemplate.talents.map(t => t.name).join(", ")}
            </div>
        </div>
    );
}
